public class F {
    public static void main(String[] args) {
        QReader in = new QReader();
        AVLTree a = new AVLTree();
        AVLTree p = new AVLTree();
        int n = in.nextInt();
        long result  =0 ;
        for (int i = 0; i < n; i++) {
            if (in.nextInt() == 0){
                int data = in.nextInt();
                if (a.root != null){
                    long pre = a.preQuery(data).data;
                    long suc = a.sucQuery(data).data;
                    if (Math.abs(pre - data) <= Math.abs(suc - data)) {
                        result += Math.abs(pre -data);
                        a.delete(pre);
                    }else {
                        result += Math.abs(suc -data);
                        a.delete(suc);
                    }
                }else {
                    p.insert(data);
                }
            }else {
                int data = in.nextInt();
                if (p.root != null){
                    long pre = p.preQuery(data).data;
                    long suc = p.sucQuery(data).data;
                    if (Math.abs(pre -data )<= Math.abs(suc -data)){
                        result += Math.abs(pre -data);
                        p.delete(pre);
                    }else {
                        result += Math.abs(suc -data);
                        p.delete(suc);
                    }
                }else {
                    a.insert(data);
                }
            }
        }
        System.out.println(result);
    }
}
class AVLTree {
    AVLNode root;

    static long qData;

    public AVLTree(AVLNode root) {
        this.root = root;
    }

    public AVLTree() {
    }

    public AVLNode preQuery(long data) {
        if (this.root == null) {
            return null;
        } else {
            AVLNode rootNode = this.root;
            AVLNode q = new AVLNode(Long.MIN_VALUE, 0, 0, 0);
            while (true) {
                if (rootNode == null) {
                    return q;
                }
                if (rootNode.data == data) {
                    return rootNode;
                } else if (rootNode.data > data) {
                    rootNode = rootNode.lc;
                } else {
                    q = rootNode;
                    rootNode = rootNode.rc;
                }
            }
        }
    }

    public AVLNode sucQuery(long data) {
        if (this.root == null) {
            return null;
        } else {
            AVLNode rootNode = this.root;
            AVLNode q = new AVLNode(Long.MAX_VALUE, 0, 0, 0);
            while (true) {
                if (rootNode == null) {
                    return q;
                }
                if (rootNode.data == data) {
                    return rootNode;
                } else if (rootNode.data < data) {
                    rootNode = rootNode.rc;
                } else {
                    q = rootNode;
                    rootNode = rootNode.lc;
                }
            }
        }
    }


    public void insert(long data) {
        if (this.root == null) {
            AVLNode node = new AVLNode(data, 1, 1, 1);
            this.root = node;
            return;
        }
        insertRec(this.root, data);
    }

    public void insertRec(AVLNode rootNode, long data) {
        rootNode.size++;
        if (data == rootNode.data) {
            rootNode.freq++;
            return;
        } else if (data > rootNode.data) {
            if (rootNode.rc == null) {
                rootNode.rc = new AVLNode(data, 1, 1, 1);
                rootNode.rc.fa = rootNode;
            } else {
                insertRec(rootNode.rc, data);
            }
        } else {
            if (rootNode.lc == null) {
                rootNode.lc = new AVLNode(data, 1, 1, 1);
                rootNode.lc.fa = rootNode;
            } else {
                insertRec(rootNode.lc, data);
            }
        }
        rootNode.high = Math.max(rootNode.lc == null ? 0 : rootNode.lc.high,
                rootNode.rc == null ? 0 : rootNode.rc.high) + 1;
        //TODO:需要旋转
        rota(rootNode);

    }

    public void delete(long data) {
        deleteRec(this.root, data);
    }

    public void deleteRec(AVLNode rootNode, long data) {
        rootNode.size--;
        if (rootNode.data == data) {
            if (rootNode.freq > 1) {
                rootNode.freq--;
            } else {
                if (isLeaf(rootNode)) {
                    remove(rootNode);
                } else if (rootNode.rc != null) {
                    findSuc(rootNode, rootNode.rc, rootNode.data, rootNode.rc);
                } else if (rootNode.lc != null) {
                    if (rootNode == this.root) {
                        this.root = rootNode.lc;
                        rootNode.lc.fa = null;
                    } else {
                        if (rootNode.fa.lc == rootNode) {
                            rootNode.fa.lc = rootNode.lc;
                            rootNode.lc.fa = rootNode.fa;
                            rootNode.fa = null;
                        } else {
                            rootNode.fa.rc = rootNode.lc;
                            rootNode.lc.fa = rootNode.fa;
                            rootNode.fa = null;
                        }
                    }
                }
            }
        } else if (data > rootNode.data) {
            deleteRec(rootNode.rc, data);
        } else {
            deleteRec(rootNode.lc, data);
        }
        rootNode.high = Math.max(rootNode.lc == null ? 0 : rootNode.lc.high,
                rootNode.rc == null ? 0 : rootNode.rc.high) + 1;
//        //TODO:需要旋转
        rota(rootNode);
    }

    public void findSuc(AVLNode target, AVLNode rootNode, long data, AVLNode q) {
        if (rootNode == null) {
            qData = q.data;

            target.data = q.data;
            target.freq = q.freq;
            AVLNode fa = q.fa;
            if (isLeaf(q)) {
                remove(q);
            } else {
                if (q ==q.fa.lc){
                    q.fa.lc = q.rc;
                }else {
                    q.fa.rc = q.rc;
                }
                q.rc.fa = q.fa;
                q.fa = null;
            }
            fa.high = Math.max(fa.lc == null ? 0 : fa.lc.high, fa.rc == null ? 0 : fa.rc.high) + 1;
            //应该不需要旋转？
            return;
        } else if (rootNode.data > data) {
            q = rootNode;
            rootNode.size--;
            findSuc(target, rootNode.lc, data, q);
        } else {
            rootNode.size--;
            findSuc(target, rootNode.rc, data, q);
        }
        rootNode.high = Math.max(rootNode.lc == null ? 0 : rootNode.lc.high,
                rootNode.rc == null ? 0 : rootNode.rc.high) + 1;
//        //TODO:需要旋转
//        if (rootNode.data = q.data)
        rota(rootNode);
    }

    private boolean isLeaf(AVLNode node) {
        return node.lc == null && node.rc == null;
    }

    private void remove(AVLNode node) {
        if (node == this.root) {
            this.root = null;
            return;
        }
        if (node.fa.rc == node) node.fa.rc = null;
        else node.fa.lc = null;
        node.fa = null;
    }

    public void print() {
        print(this.root);
    }

    public void print(AVLNode node) {
        if (node == null) return;
        long rcData = node.rc == null ? 0 : node.rc.data;
        long lcData = node.lc == null ? 0 : node.lc.data;
        System.out.println("data:" + node.data + " lc: " + lcData + " rc: " + rcData + " freq: " + node.freq + " size: " + node.size + " high: " + node.high);
        print(node.lc);
        print(node.rc);
    }

    public void rota(AVLNode node) {
        if (isLeaf(node)) return;
        int rh = node.rc == null ? 0 : node.rc.high;
        int lh = node.lc == null ? 0 : node.lc.high;
        if (rh - lh <= 1 && rh - lh >= -1) {
            return;
        }
        if (lh - rh >= 2) {
            int llh = node.lc.lc == null ? 0 : node.lc.lc.high;
            int lrh = node.lc.rc == null ? 0 : node.lc.rc.high;
            if (llh >= lrh) {
                rightRot(node);
            } else {
                leftRot(node.lc);
                rightRot(node);
            }
        } else if (rh - lh >= 2) {
            int rrh = node.rc.rc == null ? 0 : node.rc.rc.high;
            int rlh = node.rc.lc == null ? 0 : node.rc.lc.high;
            if (rrh >= rlh) {
                leftRot(node);
            } else {
                rightRot(node.rc);
                leftRot(node);
            }
        }
    }

    public void rightRot(AVLNode node) {
        AVLNode fa = node.fa;
        AVLNode a = node;
        AVLNode b = node.lc;
        AVLNode subA = b.lc;
        AVLNode subB = b.rc;
        AVLNode subC = a.rc;
        int aRH = (subC == null ? 0 : subC.high) + 1;
        int bLH = (subA == null ? 0 : subA.high) + 1;
        int bRH = (subB == null ? 0 : subB.high) + 1;
        int subASize = subA == null ? 0 : subA.size;
        int subBSize = subB == null ? 0 : subB.size;
        int subCSize = subC == null ? 0 : subC.size;
        if (this.root == node) {
            this.root = b;
            b.fa = null;
        } else {
            if (fa.rc == a) {
                fa.rc = b;
                b.fa = fa;
            } else {
                fa.lc = b;
                b.fa = fa;
            }
        }
        b.rc = a;
        a.fa = b;
        a.lc = subB;
        if (subB != null) subB.fa = a;
        a.high = Math.max(aRH, bRH);
        b.high = Math.max(a.high + 1, bLH);
        a.size = subBSize + subCSize + a.freq;
        b.size = subASize + a.size + b.freq;
    }

    public void leftRot(AVLNode node) {
        AVLNode fa = node.fa;
        AVLNode a = node;
        AVLNode b = node.rc;
        AVLNode subA = b.rc;
        AVLNode subB = b.lc;
        AVLNode subC = a.lc;
        int aLH = (subC == null ? 0 : subC.high) + 1;
        int bLH = (subB == null ? 0 : subB.high) + 1;
        int bRH = (subA == null ? 0 : subA.high) + 1;
        int subASize = subA == null ? 0 : subA.size;
        int subBSize = subB == null ? 0 : subB.size;
        int subCSize = subC == null ? 0 : subC.size;
        if (a == this.root) {
            this.root = b;
            b.fa = null;
        } else {
            if (fa.rc == a) {
                fa.rc = b;
                b.fa = fa;
            } else {
                fa.lc = b;
                b.fa = fa;
            }
        }
        b.lc = a;
        a.fa = b;
        a.rc = subB;
        if (subB != null) subB.fa = a;
        a.high = Math.max(aLH, bLH);
        b.high = Math.max(a.high + 1, bRH);
        a.size = subCSize + subBSize + a.freq;
        b.size = subASize + a.size + b.freq;
    }

    public AVLNode findKth(int k) {
        AVLNode rootNode = this.root;
        while (true) {
            int rs = rootNode.rc == null ? 0 : rootNode.rc.size;
            int ls = rootNode.lc == null ? 0 : rootNode.lc.size;
            if (k <= ls) {
                rootNode = rootNode.lc;
            } else if (k > ls && k <= ls + rootNode.freq) {
                return rootNode;
            } else if (k > rootNode.freq + ls) {
                k = k - ls - rootNode.freq;
                rootNode = rootNode.rc;
            }
        }
    }


}

class AVLNode {
    long data;
    int high;
    int freq;
    int size;
    AVLNode fa;
    AVLNode lc;
    AVLNode rc;


    public AVLNode(long data, int high, int freq, int size) {
        this.data = data;
        this.high = high;
        this.freq = freq;
        this.size = size;
    }
}