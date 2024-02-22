package com.example.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class LeetCodeApplicationTests {


    @Test
    void contextLoads() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new ArrayList();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
// test
// contextLoads
        //11111
        //git config --global user.name "New User Name"
//        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
//            if (nums[i] > 0){
//                return res;
//            }
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                //这里我们为什么不用  nums[i] == nums[i+1]呢，是因为 [-1,-1,2]这种情况就会跳过
//                //但是nums[i] == nums[i-1]的话，其已经完成 i=0是的操作了
//                continue;
//            }
            if (map.containsKey(nums[i])) {
                continue;
            }

            map.put(nums[i], 1);

            while (start < end) {
                if (nums[i] + nums[start] + nums[end] > 0) {
                    //值太大，end左移，减少值
                    end--;
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    //值太小，start右移，增大值
                    start++;
                } else if (nums[i] + nums[start] + nums[end] == 0) {
                    //相加等于0，start右移，end左移，寻找下一组数
                    //判断是否与上一组数相同
//                    if (i == start-1 || (start < end && nums[start] != nums[start-1])) {
//                        res.add(Arrays.asList(nums[i], nums[start], nums[end]));
//                    }
                    if (map1.containsKey(nums[start] + nums[end])) {
                        res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    }
                    map1.put(nums[start] + nums[end], 1);

                    //这里做一个去重的操作 如果我们的下一组left或则right和当前这组数据相同的话
                    //那就会出现重复
//                    while(start < end && nums[start] == nums[start+1]){
//                        start++;
//                    }
//                    while(start < end && nums[end] == nums[end-1]){
//                        end--;
//                    }
                    start++;
                    end--;
                }
            }
        }
//        return res;
        System.out.println("res:" + res);
//        return medianNum;
    }

}
