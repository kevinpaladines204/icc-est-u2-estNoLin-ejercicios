package main.Ejercicio_03_listLeves;
import main.Materia.Models.Node;
import java.util.*;

public class ListLevels{
    public List<List<Node>> listLevels(Node root){
        List<List<Node>> result = new ArrayList<>();

        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int lSize = queue.size();
            List<Node> lNodes = new ArrayList<>();

            for(int i = 0; i < lSize; i++){
                Node aux = queue.poll();
                lNodes.add(aux);

                if(aux.getLeft() != null) queue.offer(aux.getLeft());
                if(aux.getRight() != null) queue.offer(aux.getRight());
            }
            result.add(lNodes);
        }
        return result;
    }
}