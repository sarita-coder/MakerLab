/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Personas;
import java.util.List;

/**
 *
 * @author SENCICO
 */
public interface DaoPersonas {
    public List<Personas> personaQry();
    public String personasIns(Personas personas);
    public String personasDel(List<Integer> ide);
    public Personas personasGet(Integer ide);
    public String personasUpd(Personas personas);
}
