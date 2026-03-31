package app;

import com.fasterxml.jackson.databind.JsonNode;
import electronique.*;

import java.util.ArrayList;
import java.util.List;

public class CircuitBuilder {

    public CircuitBuilder(){

    }

    public Composant construireCircuit(String nom){
        return null;
    }


    private Composant lireComposant(JsonNode node){
        String type = node.get("type").asText();
        if ("resistance".equals(type)) {
            return new Resistance(node.get("Valeur").asDouble());
        } else if ("parallele".equals(type)) {
            List<Composant> composants = new ArrayList<>();
            for (JsonNode composantNode : node.get("composants")) {
                composants.add(lireComposant(composantNode));
            }
            return new CircuitParallele(composants);
            }
          else if ("serie".equals(type)) {
            List<Composant> composants = new ArrayList<>();
            for (JsonNode composantNode : node.get("composants")) {
                composants.add(lireComposant(composantNode));
            }
            return new CircuitSerie(composants);
        }
        throw new IllegalArgumentException("Type de circuit inconnu : " + type);
    }
}