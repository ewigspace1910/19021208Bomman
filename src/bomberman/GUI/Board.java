package bomberman.GUI;

import bomberman.entities.Entities;
import bomberman.entities.dynamicEntities.Player;
import bomberman.graphics.Render;

import java.awt.*;
import java.util.Vector;

public class Board implements Render {
    //etities
    private Player player;
    private final Vector<Entities> _entities;
    private final Vector<Entities> _delEntities;

    public Board() {
        _entities = new Vector<>();
        _delEntities = new Vector<>();
    }

    @Override
    public void update() {
        try {
            for (int i = 0; i < _entities.size(); i++) {
                if (_entities.get(i) != null) _entities.get(i).update();
            }
        } catch (Exception e) {
            System.out.println("Error Board update");
            System.out.println(e.toString());
            System.exit(-3);
        }
    }

    @Override
    public void render(Graphics g) {
        try {
            for (Entities entity : _entities) {
                if (entity != null && !entity.isRemoved()) {
                    entity.render(g);
                }
                else {
                    _delEntities.add(entity);
                }
            }
            for (Entities x : _delEntities) _entities.remove(x);
            _delEntities.removeAllElements();
        } catch (Exception e) {
            System.out.println("Error Board render");
        }
    }

    //==================================================================================================================
    // GETTER
    //==================================================================================================================

    public Player getPlayer() {
        return player;
    }


    //==================================================================================================================
    // setter / adder
    //==================================================================================================================

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addEntity(Entities x) {
        _entities.add(x);
    }
}
