/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penilaian_mahasiswa;

import java.sql.SQLException;

/**
 *
 * @author uin malang
 */
public class Tree {

    Penilaian root;
    String[] data, dataName;
    int size;
    CRUD cr = new CRUD();

    public Tree() throws SQLException {
        root = null;
        data = new String[size];
        dataName = new String[size];
    }

    public void insert(int id, String nama, String nim, String ComBox, String istima, String kalam, String kitabah, String qiroah) {
        Penilaian newTravel = new Penilaian(id, 0, nama, nim, ComBox, istima, kalam, kitabah, qiroah);
        if (root == null) {
            root = newTravel;
        } else {
            Penilaian current = root;
            Penilaian parent;
            while (true) {
                parent = current;
                if (current.getId() == id) {
                    System.out.println("Cant insert," + id + " already exist ");
                }
                if (id < current.getId()) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newTravel;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newTravel;
                        return;
                    }
                }
            }
        }
    }

    public Penilaian edit(int id, String nama, String nim, String ComBox, String istima, String kalam, String kitabah, String qiroah) {
        Penilaian current = root;
        if (root.getId() == id) {
            current.setNama(nama);
            current.setNim(nim);
            current.setKelas(ComBox);
            current.setIstima(istima);
            current.setKalam(kalam);
            current.setKitabah(kitabah);
            current.setQiroah(qiroah);
        }
        while (current.getId() != id) {
            if (id < current.getId()) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                break;
            }
            if (current.getId() == id) {
                current.setNama(nama);
                current.setNim(nim);
                current.setKelas(ComBox);
                current.setIstima(istima);
                current.setKalam(kalam);
                current.setKitabah(kitabah);
                current.setQiroah(qiroah);
            }
        }
        return current;
    }

    public void delete(int key) {
        Penilaian current = root;
        Penilaian parent = root;
        boolean isLeftChild = true;
        while (current.getId() != key) {
            parent = current;
            if (key < current.getId()) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                break;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Penilaian successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
    }

    private Penilaian getSuccessor(Penilaian delTumbuhan) {
        Penilaian successorParent = delTumbuhan;
        Penilaian successor = delTumbuhan;
        Penilaian current = delTumbuhan.leftChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delTumbuhan.rightChild) {
            successorParent.leftChild = delTumbuhan.rightChild;
            successor.rightChild = delTumbuhan.rightChild;
        }
        return successor;
    }

    public String[][] search(String term) {
        int i = 0;
        Stack stack = new Stack(size);
        String[] result[] = new String[size][6];

        stack.push(root);
        while (!stack.isEmpty()) {
            Penilaian current = stack.pop();
            if (current.getNama().contains(term) || current.getNim().contains(term) || current.getKelas().contains(term) || current.getIstima().contains(term) || current.getKalam().contains(term) || current.getKitabah().contains(term)) {
                String[] data = {current.getNama(), current.getNim(), current.getKelas(), current.getIstima(), current.getKalam(), current.getKitabah(), current.getQiroah()};
                result[i++] = data;
            }
            if (current.leftChild != null) {
                stack.push(current.leftChild);
            }
            if (current.rightChild != null) {
                stack.push(current.rightChild);
            }
        }
        i = 0;
        return result;
    }

}
