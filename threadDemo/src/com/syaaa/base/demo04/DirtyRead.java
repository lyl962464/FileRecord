package com.syaaa.base.demo04;

/**
 * @author syaaa
 * @version 1.0
 * @date 14:02   2018/11/20
 **/
public class DirtyRead   {

    private String username = "syaaa";
    private String password = "syaaa";

    private synchronized  void setValue(String username,String password){
        this.username = username;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
        System.out.println("setValue最终结果：username = " + username + " , password = " + password);
    }


    private void getValue(){
        System.out.println("getValue方法得到：username = " + this.username + " , password = " + this.password);
    }


    public static void main(String[] args) throws InterruptedException {
        final DirtyRead dr = new DirtyRead();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                dr.setValue("z3", "456");
            }
        },"t1");

        t1.start();
        Thread.sleep(1000);

        dr.getValue();
    }







}
