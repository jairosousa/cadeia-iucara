/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.bean.converter;

import br.com.ufra.entidades.CestoAcai;
import br.com.ufra.rn.CestoAcaiRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jairo Sousa
 */
@FacesConverter(value = "cestoAcaiConverter")
public class CestoAcaiConverter implements Converter {

    private final CestoAcaiRN rn = new CestoAcaiRN();

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
            CestoAcai cesto = (CestoAcai) o;
            if (cesto.getId() == null) {
                return null;
            }
            return cesto.getId().toString();
        }
    }

}
