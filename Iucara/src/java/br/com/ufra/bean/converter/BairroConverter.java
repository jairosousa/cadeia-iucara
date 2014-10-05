/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.bean.converter;

import br.com.ufra.entidades.Bairro;
import br.com.ufra.rn.BairroRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

/**
 *
 * @author Jairo Sousa
 */
@FacesConverter(value = "bairroConverter")
public class BairroConverter implements Converter{
    
     private final BairroRN rn = new BairroRN();

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
            Bairro bairro = (Bairro) o;
            if (bairro.getId() == null) {
                return null;
            }
            return bairro.getId().toString();
        }
    }
    
}
