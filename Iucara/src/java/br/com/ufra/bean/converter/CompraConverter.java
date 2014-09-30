/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.bean.converter;

import br.com.ufra.entidades.Batedor;
import br.com.ufra.entidades.Compra;
import br.com.ufra.rn.CompraRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Jairo Sousa
 */
public class CompraConverter implements Converter {

    private final CompraRN rn = new CompraRN();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string.isEmpty()) {
            return null;
        } else {
            Integer id = new Integer(string);
            return rn.obter(id);
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        } else {
            Compra compra = (Compra) o;
            if (compra.getId() == null) {
                return null;
            }
            return compra.getId().toString();
        }
    }
}
