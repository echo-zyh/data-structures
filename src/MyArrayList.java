import sun.font.CreatedFontTracker;

import java.util.Arrays;

/**
 * @Author: echo Zhao
 * @Descciption:
 * @Date: Created in 10:56 2020/7/27 0027
 * @Modified By:
 */
public class MyArrayList {
    public int [] elem;
    public int usedSize;

    public MyArrayList(){
        this.elem = new int [10];
        this.usedSize = 0;
    }
    public MyArrayList(int a){
        this.elem = new int[a];
        this.usedSize = 0;
    }

    //打印顺序表
    public void display(){
        for (int i=0;i<usedSize;i++){
            System.out.print(elem[i]+" ");
        }
    }
    //在 pos 位置新增元素
    public void add(int pos,int data){
        if(pos<0||pos>usedSize) {
            System.out.println("插入位置不合法");
            return;
        }
        //扩容
        if(usedSize==elem.length){
            int[] newelem=new int[this.elem.length * 2];
            for (int i = 0; i <this.elem.length ; i++) {
                newelem[i] = this.elem[i];
            }
            this.elem = newelem;
        }
        //尾插
        if (pos==usedSize){
            elem[pos] = data;
        }
        //中间插
        int i=this.usedSize-1;
        for (;i>=pos;i--){
            elem[i+1]=elem[i];
        }
            this.elem[pos] = data;
            this.usedSize++;
        }
        //是否包含目标元素
        public boolean contains(int toFind){
            for (int i=0;i<usedSize;i++){
                if(elem[i]==toFind){
                    return true;
                }
            }
            return false;
        }
        //搜索目标元素对应下标
        public int search (int toFind) {
            for (int i = 0; i < usedSize; i++) {
                if (elem[i] == toFind) {
                    return i;
                }

            }
            return -1;
        }
        //获取当前下标的元素
        public int getPos(int Pos){
        if(Pos<0||Pos>usedSize) {
            return -1;
        }
            return elem[usedSize-1];
        }

        public void setPos(int pos,int value){
            elem[pos] = value;
        }
        //获取数组大小
        public int size(){
            return usedSize;
        }

        public void clear(){
            usedSize=0;
        }
        //删除当前元素
        public void remove(int toRemove){
            int i =search(toRemove);
            if (i==-1){
                System.out.println("未找到key");
                return;
            }
            for (;i<usedSize-1;i++){
                this.elem[i]=elem[i+1];
            }
            usedSize--;
        }
    }

