package main;
import utils.StudentValidator;
import main.Materia.Models.Node;
import main.Materia.Controllers.ArbolBinario;

import java.util.List;

import main.Ejercicio_01_insert.InsertBST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Ejercicio_04_depth.Depth;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        System.out.println();
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ

        int[] lista = {12, 10, 14, 9, 11, 13, 15};
        Node root = null;
        ArbolBinario print = new ArbolBinario();

        System.out.println();
        System.out.println("---- Ejercicio 1 ----");

        InsertBST insert = new InsertBST();
        for (int valor: lista){
            root = insert.insert(root, valor);
        }
        print.printTreeNode2(root," ",true);
        System.out.println();

        System.out.println("---- Ejercicio 2 ----");

        Node rootCopia = cloneTree(root);
        System.out.println("Arbol original : ");
        print.printTreeNode2(root," ",true);
        InvertBinaryTree invertir = new InvertBinaryTree();
        Node invertido = invertir.invertTree(rootCopia);
        System.out.println();
        System.out.println("Arbol despues de invertir : ");
        print.printTreeNode2(invertido, "", true);
        System.out.println();

        System.out.println("---- Ejercicio 3 ----");

        System.out.println("Arbol original :");
        print.printTreeNode2(root," ",true);
        System.out.println();

        ListLevels listaNiveles = new ListLevels();
        List<List<Node>> niveles = listaNiveles.listLevels(root);
        System.out.println("Niveles listados : ");
        for (List<Node> level : niveles) {
            StringBuilder nivels = new StringBuilder();
            for (int i = 0; i < level.size(); i++) {
                nivels.append(level.get(i).getValue());
                if (i < level.size() - 1) nivels.append(" -> ");
            }
            System.out.println(nivels);
        }
        System.out.println();

        System.out.println("---- Ejercicio 4 ----");

        System.out.println("Arbol original :");
        print.printTreeNode2(root," ",true);
        Depth depth = new Depth();
        int prfndd = depth.maxDepth(root);
        System.out.println();
        System.out.println("Profundidad del árbol : " + prfndd);
        System.out.println();
    }

    // metodo para que el arbol no se clone en el ejer2, ya que en eljer 3 y 4 se necesita el arbol original
    public static Node cloneTree(Node root) {
        if (root == null) return null;
        Node newNode = new Node(root.getValue());
        newNode.setLeft(cloneTree(root.getLeft()));
        newNode.setRight(cloneTree(root.getRight()));
        return newNode;
    }
}
