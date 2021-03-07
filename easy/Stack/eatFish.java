package Stack;

import java.util.Stack;

/**
 * @program: 大鱼吃小鱼
 * @description: 在水中有许多鱼，可以认为这些鱼停放在 x 轴上。
 * 再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。
 * 这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。
 * 鱼的行为符合以下几个条件:
 * 1）所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；
 * 2）当方向相对时，大鱼会吃掉小鱼；  鱼的大小都不一样。
 * 输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]  输出：3
 * 请完成以下接口来计算还剩下几条鱼？
 * @author: poooooi
 * @create: 2021-03-06 22:53
 **/

public class eatFish {
    private static int eatFishNum(int[] fishSize, int[] fishDirection) {
        final int fishNum = fishSize.length;    //拿到鱼的数量
        if(fishNum <= 1) return fishNum;        //若鱼的数量不大于1，则直接返回数量即可

        final int left = 0;
        final int right = 1;

        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<fishNum;i++){
//            boolean hasEat = false;
            int curFishDirection = fishDirection[i];
            int curFishSize = fishSize[i];
            // 如果栈中还有鱼，并且栈中鱼向右，当前的鱼向左游，那么就会有相遇的可能性
            if(!stk.empty() && fishDirection[stk.peek()] == right && curFishDirection == left){
                if(curFishSize > fishSize[stk.peek()]){
                    stk.pop();
                    continue;
//                    hasEat = true;
                }
            }
//            if(!hasEat){
                stk.push(i);
//            }
        }
        return stk.size();
    }

    public static void main(String[] args) {
        int[] Size = {4, 2, 5, 3, 1};
        int[] Dir = {1, 1, 0, 0, 0};

        System.out.println("剩余条数" + ":" + eatFishNum(Size,Dir));
    }
}
