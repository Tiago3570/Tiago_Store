package com.example.TDS_Store_Back.json.parser;

import com.example.TDS_Store_Back.facade.dto.ProduitDTO;
import com.example.TDS_Store_Back.json.ProduitJson;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("produitJsonParser")
public class ProduitJsonParser implements Converter<ProduitJson, ProduitDTO> {

    @Override public ProduitDTO convert(final ProduitJson source)
    {
        final ProduitDTO target = new ProduitDTO();
        target.setId(source.getId());
        target.setNom(source.getNom());
        target.setPrix(source.getPrix());
        target.setCreationDate(source.getCreationDate());
        target.setModificationDate(source.getModificationDate());
        return target;
    }
}
