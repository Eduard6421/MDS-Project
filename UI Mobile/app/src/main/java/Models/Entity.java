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
    
    protected Integer Id;

    public Entity() {

    }

    public Entity(Integer id) {
        this.Id = id;
    }

    public void setId(Integer id){
        Id = id;
    }
    
    public Integer getId(){
        return Id;
    }
    
}
