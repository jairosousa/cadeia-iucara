package br.com.ufra.bean.converter;

import br.com.ufra.entidades.Atravessador;
import br.com.ufra.rn.AtravessadorRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jairo Sousa
 */
@FacesConverter(value = "atravessadorConverter")
public class AtravessadorConverter implements Converter {
    
    private final AtravessadorRN rn = new AtravessadorRN();

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
            Atravessador atravessador = (Atravessador) o;
            if (atravessador.getId() == null) {
                return null;
            }
            return atravessador.getId().toString();
        }
    }

}