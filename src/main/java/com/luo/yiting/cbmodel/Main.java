package com.luo.yiting.cbmodel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        scanner.close();
        int N = Integer.parseInt(line1);
        String[] arr = line2.split(" ");
        double[] days = new double[N + 1];
        for (int i = 1; i <= N; i++) {
            days[i] = Double.parseDouble(arr[i - 1]);
        }
        double[] dp = new double[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            if (days[i] == 0) {
                days[i] = 0;
                dp[i] += dp[i - 1];
            } else if (days[i] == 1) {
                days[i] = days[i - 1] + 1;
                dp[i] += dp[i - 1];
            } else {
                days[i] = days[i - 1] + 1.0 / 2;
                dp[i] += 1.0 / 2 * (dp[i - 1] + days[i]);
            }
        }
        System.out.println(dp[N]);

    }
//    #include <iostream>
//#include <cstdio>
//#include <vector>
//    using namespace std;
//    int main(){
//        int n;
//        cin>>n;
//        vector<int> t(n+1, 0);
//        vector<double> len(n+1,0);
//        vector<double> dp(n+1,0);
//        for(int i = 1; i <=n;i++){
//            cin >> t[i];
//            for(int i = 1;i <=n;i++){
//                if(t[i]==0){
//                    len[i] = 0;
//                    dp[i]+=dp[i-1];
//                }else if(t[i]==1) {
//                    len[i] = len[i-1]+1;
//                    dp[i]+=dp[i-1];
//                }else{
//                    len[i] = len[i-1]+1.0/2;
//                    dp[i]+=1.0/2 * (dp[i-1]+len[i]);
//                }
//            }
//            cout<<dp[n]<<endl;
//            return 0;
//        }
//    }
}
