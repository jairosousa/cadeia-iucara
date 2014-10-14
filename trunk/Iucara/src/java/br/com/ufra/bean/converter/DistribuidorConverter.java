/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.bean.converter;

import br.com.ufra.entidades.Distribuidor;
import br.com.ufra.rn.DistribuidorRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jairo Sousa
 */
@FacesConverter(value = "distribuidorConverter")
public class DistribuidorConverter implements Converter {

    private final DistribuidorRN rn = new DistribuidorRN();

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
            Distribuidor distribuidor = (Distribuidor) o;
            if (distribuidor.getId() == null) {
                return null;
            }
            return distribuidor.getId().toString();
        }
    }
}
