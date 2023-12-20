/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nganhangoop;

/**
 *
 * @author add
 */
public class Student {
    // Xin chao tat ca cac ban
    private String name;
    private int id;
    private String nganhHoc;
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.nganhHoc = nganhHoc;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nganhHoc
     */
    public String getNganhHoc() {
        return nganhHoc;
    }

    /**
     * @param nganhHoc the nganhHoc to set
     */
    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }
    
}
