/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Teacher;

/**
 *
 * @author Acer
 */
public class teacher {
    int code;
    double coeff;

    public teacher(int code, double coeff) {
        this.code = code;
        this.coeff = coeff;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    @Override
    public String toString() {
        return "teacher{" + "code=" + code + ", coeff=" + coeff + '}';
    }
    
    
    
}
