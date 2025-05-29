package Playground;

//https://leetcode.com/problems/simple-bank-system/
public class SimpleBankSystem {
    class Bank {

        int n;
        long[] balance;

        public Bank(long[] balance) {
            this.n = balance.length;
            this.balance = balance;
        }

        private boolean valid(int account){
            if(account < 1 || account > n){
                return false;
            }else{
                return true;
            }
        }

        public boolean transfer(int account1, int account2, long money) {
            if(!valid(account1) || !valid(account2)){
                return false;
            }else{
                if(money > balance[account1-1]){
                    return false;
                }else{
                    balance[account1-1] -= money;
                    balance[account2-1] += money;
                    return true;
                }
            }
        }

        public boolean deposit(int account, long money) {
            if(!valid(account)){
                return false;
            }else{
                balance[account-1] += money;
                return true;
            }
        }

        public boolean withdraw(int account, long money) {
            if(!valid(account)){
                return false;
            }else if(balance[account-1] < money){
                return false;
            }else{
                balance[account-1] -= money;
                return true;
            }
        }
    }

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
}
