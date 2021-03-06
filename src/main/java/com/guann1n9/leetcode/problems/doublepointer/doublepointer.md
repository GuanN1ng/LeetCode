### 双指针
双指针，指的是在遍历对象的过程中，不是普通的使用单个指针进行访问，而是使用两个相同方向（快慢指针）或者相反方向（对撞指针）的指针进行扫描，从而达到相应的目的。

####  快慢指针
快慢指针的两个指针从同一侧开始遍历数组或链表，一般都初始化指向链表的头结点 head，前进时快指针 fast 每次向后移动两个位置，慢指针 slow 每次向后移动一个位置
```
    ListNode fast, slow;
    fast = slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next; 、、加2
        slow = slow.next; //加1
    }
```
#### 证明链表有环时为什们快慢指针一定会相遇？

这个问题你可以用数学归纳法来思考。首先，由于链表是个环，所以相遇的过程可以看作是快指针从后边追赶慢指针的过程。那么做如下思考：
1：快指针与慢指针之间差一步。此时继续往后走，慢指针前进一步，快指针前进两步，两者相遇。
2：快指针与慢指针之间差两步。此时唏嘘往后走，慢指针前进一步，快指针前进两步，两者之间相差一步，转化为第一种情况。
3：快指针与慢指针之间差N步。此时继续往后走，慢指针前进一步，快指针前进两步，两者之间相差(N+1-2)-> N-1步。

得出结论：设距离为N，由于每次迭代两者距离减一，则经过N次必定重合，且`必定慢指针的第一圈之内就会相遇`；如果每次迭代两者距离减少的值不是一而是其他数字，则不一定会重合



#### 左右指针
左右指针在数组中实际是指两个索引值，一般初始化为 left = 0，right = nums.length - 1

代码模板
```
    int left = 0
    int right = array.lenght-1;
    
    while(left <= right){
        ...  //do somethings
        if(...){
            left++;
        }else{
            right--;
        }    
    
    }
```
