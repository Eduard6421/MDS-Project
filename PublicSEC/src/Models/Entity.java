/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author t-edpoes
 */
public class Entity {

    protected int Id;

    Entity() {
        this.Id = 0;
    }

    Entity(int Id) {
        this.Id = Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

}
