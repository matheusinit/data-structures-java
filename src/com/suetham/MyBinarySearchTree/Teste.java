/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

/**
 *
 * @author 20201014040024
 */
public class Teste {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(50);
        
        tree.insert(30);
        
        tree.insert(20);
        
        tree.insert(70);
        
        tree.insert(40);
        
        tree.insert(60);
        
        tree.insert(80);

        // Removes
        
        tree.remove(30);
        
        tree.remove(40);
        
        tree.remove(60);
        
        tree.remove(70);
        
//        tree.insert(24);
//        
//        tree.insert(30);
//        
//        tree.insert(20);
//        
//        tree.insert(15);
//        
//        tree.insert(0)
        
        tree.inOrder(tree.root());
    }
}

// Initial state

//                      50
//              30              70
//          20      40      60      80


// Remove 30

//                      50
//              40              70
//          20              60      80

// Remove 40

//                      50
//              20              70
//                          60      80

// Remove 60

//                      50
//              20              70
//                                  80

// Remove 70

//                      50
//              20              80