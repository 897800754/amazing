package test.collection;

import javax.jws.WebParam;
import java.util.Collections;

/**
 * @author: cg1
 * @date: 2021-07-05 11:46
 **/
public class MyRBTree {
    public static void main(String[] args) {
        //   binarySearch(2121, 1, 20, 21, 2121,3333,5555);
        RBTree<String, String> tree = new RBTree<>();
        tree.insert("1", "A");
        tree.insert("2", "A");
        tree.insert("3", "A");
        System.out.println(tree);
        tree.inOrderPrint();

    }


    /**
     * 红黑树
     * 1.创建BRTree,定义颜色
     * 2.创建BRNode
     * 3.辅助方法定义: parentOf(node) ,isRed(Node),setRed(Node),setBlack(Node),inOrderPrint();
     * 4.左旋方法定义: leftRotate(Node)
     * 5.右旋方法定义: rightRotate(Node)
     * 6.公开插入接口方法定义: insert(K key,V value)
     * 7.内部插入接口方法定义: insert(RBNode node)
     * 8.修正插入导致红黑树失衡的方法定义: insertFixUp(RBNode node)
     * 9.测试红黑树正确性
     *
     * @param <K>
     * @param <V>
     */
    static class RBTree<K extends Comparable<K>, V> {
        private static final boolean RED = true;
        private static final boolean BLACK = false;

        private RBNode<K, V> root;

        /**
         * 返回父节点
         *
         * @param node
         * @return
         */
        private RBNode<K, V> parentOf(RBNode<K, V> node) {
            if (node != null) {
                return node.parent;
            }
            return null;
        }

        private boolean isRed(RBNode<K, V> node) {
            if (node == null) {
                throw new RuntimeException("null");
            }
            return node.color;
        }

        private boolean isBlack(RBNode<K, V> node) {
            if (node == null) {
                throw new RuntimeException("null");
            }
            return !node.color;
        }

        private RBNode<K, V> setBlack(RBNode<K, V> node) {
            if (node != null) {
                node.setColor(BLACK);
                return node;
            }
            return null;
        }

        private RBNode<K, V> setRed(RBNode<K, V> node) {
            if (node != null) {
                node.setColor(RED);
                return node;
            }
            return null;
        }

        /**
         * 打印树
         */
        public void inOrderPrint() {
            inOrderPrint(this.root);
        }

        /**
         * 中序遍历
         *
         * @param node
         */
        private void inOrderPrint(RBNode<K, V> node) {
            if (node != null) {
                inOrderPrint(node.left);
                System.out.println("key: " + node.key + " value: " + node.value);
                inOrderPrint(node.right);
            }
        }

        /**
         * 插入方法
         *
         * @param k
         * @param v
         * @return
         */
        public void insert(K k, V v) {
            RBNode<K, V> node = new RBNode<>();
            node.setKey(k);
            node.setValue(v);
            //茶润节点一定为红色节点
            node.setColor(RED);
            insert(node);
        }

        /**
         * 插入内部方法
         *
         * @param node
         * @return
         */
        //todo
        private void insert(RBNode<K, V> node) {
            RBNode<K, V> parent = null;
            RBNode<K, V> x = this.root;
            //找到父节点 x
            while (x != null) {
                parent = x;
                int cmp = node.key.compareTo(x.key);
                if (cmp > 0) {
                    //cmp > 0 说明 node.key 大于x.key 需要在右子树查找
                    x = x.right;
                } else if (cmp == 0) {
                    //cmp = 0 说明 node.key ==x.key 值替换
                    x.setValue(node.getValue());
                    return;
                } else {
                    //cmp < 0 说明 node.key 大于x.key 需要在左子树查找
                    x = x.left;
                }
            }
            //与父节点进行比较
            if (parent != null) {
                int cmp = parent.key.compareTo(node.key);
                if (cmp > 0) {
                    //父亲大
                    parent.left = node;
                } else {
                    parent.right = node;
                }
                //插入节点 指向父节点
                node.parent = parent;

            } else {
                this.root = node;
                node.color = BLACK;
                return;
            }
            System.out.println(this.root);
            //修复红黑树平衡
            insertFixUp(node);

        }

        /**
         * |---红黑树的插入
         * |---场景1:红黑树为空树
         * 将根节点染为黑色
         * |---场景2:插入节点的Key已经存在
         * 不需要处理
         * |---场景3:插入节点的父节点为黑色
         * 红黑树依然平衡,不需要处理
         * |---场景4:插入节点的父节点为红色
         * |---场景4.1: 叔叔节点存在,并且为红色(叔-父双红) ->黑红红==>>红黑红 再以爷爷节点为当前节点再做处理
         * <p>
         * |---场景4.2: 叔叔节点不存在,或者为黑色,父节点为爷爷节点的左子树
         * |---场景4.2.1: 插入节点为其父节点的左子节点(LL双红)
         * 将父亲节点转为黑色,爷爷节点染为红色,以爷爷节点为旋转点,右旋
         * |---场景4.2.2: 插入节点为其父节点的右子节点(LR双红) LR双红->LL双红
         * 以父节点为旋转点,左旋,形成LL双红
         * |---场景4.3:叔叔节点不存在,或者为黑色,父节点为爷爷节点的右子树
         * |---场景4.3.1: 插入节点为其父节点的右子节点(RR双红) RR双红
         * 双红处理, 以爷爷节点为旋转点进行左旋,以爷爷节点为当前节点,再进行处理
         * |---场景4.3.2: 插入节点为其父节点的左子节点(RL双红) RL双红->RR双红
         * 以父节点为旋转点,右旋转为RR双红
         *
         * @param node
         */
        private void insertFixUp(RBNode<K, V> node) {
            RBNode<K, V> parent = parentOf(node);
            RBNode<K, V> uncle = null;
            RBNode<K, V> gParent = parentOf(parent);
            if (parent.left == node) {
                uncle = parent.right;
            } else {
                uncle = parent.left;
            }
            if (isRed(parent)) {
                if (uncle != null && isRed(uncle)) {
                    //双红
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gParent);
                } else if (uncle == null || isBlack(uncle)) {
                    if (gParent.left == parent) {
                        if (parent.right == node) {
                            leftRotate(parent);
                        }
                        setBlack(parent);
                        setBlack(uncle);
                        setRed(gParent);
                        rightRotate(gParent);
                        insertFixUp(gParent);
                    } else {
                        if (parent.left == node) {
                            rightRotate(parent);
                        }
                        setBlack(parent);
                        setBlack(uncle);
                        setRed(gParent);
                        leftRotate(gParent);
                        insertFixUp(gParent);

                    }

                }

            }

        }

        /**
         * 左旋
         * 以一个节点为旋转节点,其右子节点变为其父节点,其右子节点的左子节点变为旋转节点的右子节点
         *
         * @param node 旋转节点
         */
        private void leftRotate(RBNode<K, V> node) {
            RBNode<K, V> right = node.right;
            if (right != null) {
                //原右子节点的左子节点指向旋转节点
                RBNode<K, V> rightLeft = right.left;
                right.left = node;
                //旋转节点的父节点指向原右子节点
                RBNode<K, V> parent = node.parent;
                if (parent != null) {
                    //旋转节点的父节点 与 其右子节点的关系变更
                    if (parent.left == node) {
                        parent.left = right;
                    } else {
                        parent.right = right;
                    }
                    right.parent = parent;
                } else {
                    //说明是根节点,根据根节点
                    this.root = right;
                }
                node.parent = right;
                //右子节点的左子节点的关系变更
                if (rightLeft != null) {
                    //旋转节点右节点->rightLeft
                    node.right = rightLeft;
                    rightLeft.parent = node;
                }
            }
        }

        /**
         * 右旋
         * 以node为旋转节点,其左子节点作为其父节点,其左子节点的右节点变为旋转节点的左子节点,左子节点不变.
         *
         * @param node 旋转节点.
         */
        private void rightRotate(RBNode<K, V> node) {
            //获取左子节点
            RBNode<K, V> left = node.left;
            if (left != null) {
                RBNode<K, V> leftRight = left.right;
                left.right = node;
                //左子节点 与 旋转节点 与 旋转节点父节点
                RBNode<K, V> parent = node.parent;
                if (parent != null) {
                    if (parent.left == node) {
                        parent.left = left;
                    } else {
                        parent.right = left;
                    }
                    left.parent = parent;
                } else {
                    //根节点
                    this.root = left;
                }
                node.parent = left;

                //左子节点的右子节点 与 旋转节点
                if (leftRight != null) {
                    node.left = leftRight;
                    leftRight.parent = node;
                }

            }

        }

        /**
         * node节点
         *
         * @param <K>
         * @param <V>
         */
        class RBNode<K extends Comparable<K>, V> {
            private RBNode<K, V> parent;
            private RBNode<K, V> left;
            private RBNode<K, V> right;
            private boolean color;
            private K key;
            private V value;


            public RBNode() {
            }

            public RBNode(RBNode<K, V> parent, RBNode<K, V> left, RBNode<K, V> right, boolean color) {
                this.parent = parent;
                this.left = left;
                this.right = right;
                this.color = color;
            }

            public K getKey() {
                return key;
            }

            public void setKey(K key) {
                this.key = key;
            }

            public V getValue() {
                return value;
            }

            public void setValue(V value) {
                this.value = value;
            }

            public RBNode<K, V> getParent() {
                return parent;
            }

            public void setParent(RBNode<K, V> parent) {
                this.parent = parent;
            }

            public RBNode<K, V> getLeft() {
                return left;
            }

            public void setLeft(RBNode<K, V> left) {
                this.left = left;
            }

            public RBNode<K, V> getRight() {
                return right;
            }

            public void setRight(RBNode<K, V> right) {
                this.right = right;
            }

            public boolean isColor() {
                return color;
            }

            public void setColor(boolean color) {
                this.color = color;
            }
        }
    }

    /**
     * 二分查找
     */
    public static void binarySearch(int target, int... arr) {
        int len = arr.length;
        int startIndex = 0;
        int endIndex = len - 1;
        int cursor = (startIndex + endIndex) / 2;

        //int cursor = startIndex +( endIndex+ startIndex) / 2;  防止溢出 int32
        while (startIndex != endIndex) {

            int cursorEle = arr[cursor];
            if (cursorEle > target) {
                endIndex = cursor;
                cursor = (startIndex + endIndex) / 2;
            } else if (cursorEle < target) {
                startIndex = cursor;
                cursor = (startIndex + endIndex) / 2;
            } else {
                //相等
                System.out.println("索引为:" + cursor);
                return;
            }
        }
    }


}
