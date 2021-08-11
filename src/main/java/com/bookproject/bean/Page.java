package com.bookproject.bean;

/**
 * @author jh
 * @create 2021-06-02-17:20
 */
public class Page {
    int start;
    int count;
    int total;

    public Page(int start, int count) {
        this.start = start;
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isHasPrevious(){
        if (start == 0)
            return false;
        return true;
    }

    public boolean isHasNext(){
        if (start == getLast())
            return false;
        return true;
    }

    public int getTotalPage(){
        int totalPages;
        if(0 == total%count){
            totalPages = total/count;
        }else {
            totalPages = total/count + 1;
        }

        if (0==totalPages){
            totalPages = 1;
        }
        return totalPages;
    }

    public int getLast(){
        int last;
        if( 0 == total % count ){  //举个栗子  total = 30  count =10   total % count = 0 正好除尽 无余数 进入if
            last = total - count;   // last = 30 - 10   最后一页第一条索引为 20
        }else{ //再举个栗子  total = 36  count =10   total % count = 6 没除尽 余数为6  进入else
            last = total - total % count ; // last = 36 - （36%10）=36-6 = 30   最后一页第一条索引为 30
        }
        last = last<0 ? 0:last;
        return last; //返回尾页的第一条数据索引
    }
}
