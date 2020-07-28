/**
 * @Author: echo Zhao
 * @Descciption:
 * @Date: Created in 15:46 2020/7/28 0028
 * @Modified By:
 */


public class myLinkedlist {
    public Node head;

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
/*        if(this.head== null){
            this.head = node;
        }*/
        node.next = head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null){
            head = node;
        }
        Node ret =this.head;
        while (ret.next!=null){
            ret = ret.next;
        }
        ret.next = node;
    }

    //任意位置插入
    public void addIndex(int index,int data){
        if (checkIndex(index)==false){
            return;
        }
        if(index == 0){
            this.addFirst(data);
            return ;
        }
        Node ret =searchPrev(index);
        Node node = new Node(data);
        node.next = ret.next;
        ret.next = node;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node ret = this.head;
        while (ret.next!=null){
            if(ret.data == key){
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null){
            return;
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
        Node ret = searchNode(key);
        if (ret == null){
            System.out.println("没有key节点");
            return;
        }
        ret.next = ret.next.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        while (searchNode(key)!=null){
            remove(key);
        }
    }

    //查找关键字key的节点
    public Node searchNode(int key){
        Node ret = this.head;
        while ((ret.next != null)) {
            if (ret.next.data == key) {
                return ret;
            }
            ret = ret.next;
        }
        return null;
    }
    //查找对应下标结点
    public Node searchPrev(int index){
        Node ret = this.head;
        int n = 0;
        while(n < index-1){
            ret = ret.next;
            n++;
        }
        return ret;
    }

    //获取链表长度
    public int getlength(){
        int count=0;
        Node ret = this.head;
        while(ret!=null){
            count++;
            ret = ret.next;
        }
        return count;
    }

    //下标合法性检验
    public boolean checkIndex(int index){
        if(index < 0|| index > this.getlength()){
            System.out.println("下标不合法！");
            return false;
        }
        return true;
    }

    //打印链表
    public void display(){
        Node ret = this.head;
        while (ret!=null){
            System.out.print(ret.data+" ");
            ret = ret.next;
        }
    }


}
