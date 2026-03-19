package com.example.SimplestCRUDExample.service;

import com.example.SimplestCRUDExample.model.Cpe;
import com.example.SimplestCRUDExample.repo.CpeRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class CpeLoader {

    private final CpeRepository repo;

    public CpeLoader(CpeRepository repo) {
        this.repo = repo;
    }

    public void loadJson() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("nvdcpe-2.0-chunk-00001.json");

        JsonNode root = mapper.readTree(input);
        JsonNode products = root.get("products");

        for (JsonNode product : products) {

            JsonNode cpeNode = product.get("cpe");

            // cpe_title
            String cpeTitle = cpeNode.get("cpeName").asText();

            // cpe_22_uri
            String cpe22Uri = null;
            if (cpeNode.has("deprecatedBy") && cpeNode.get("deprecatedBy").size() > 0) {
                cpe22Uri = cpeNode
                        .get("deprecatedBy")
                        .get(0)
                        .get("cpeName")
                        .asText();
            }

            // reference_links
            String referenceLink = null;
            if (product.has("references")) {

                JsonNode refs = product.get("references");

                for (JsonNode ref : refs) {
                    if (ref.has("url")) {
                        referenceLink = ref.get("url").asText();
                        break;
                    }
                }
            }

            // cpe_deprecation_date
            String deprecationDate = null;
            if (cpeNode.has("deprecated") && cpeNode.get("deprecated").asBoolean()) {
                if (cpeNode.has("lastModified")) {
                    deprecationDate = cpeNode.get("lastModified").asText();
                }
            }

            Cpe cpe = new Cpe();
            cpe.setCpeTitle(cpeTitle);
            cpe.setCpe22Uri(cpe22Uri);
            cpe.setReferenceLinks(referenceLink);
            cpe.setCpeDeprecationDate(deprecationDate);

            repo.save(cpe);
        }
    }
}