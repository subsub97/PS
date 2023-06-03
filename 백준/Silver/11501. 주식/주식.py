n = int(input())
for _ in range(n):
    max_profit = 0
    balance = 0
    k = int(input())
    stock_prices = list(map(int,input().split()))
    for i in range(k-1,-1,-1):
        if (stock_prices[i] > max_profit):
            max_profit = stock_prices[i]
        else:
            balance += max_profit - stock_prices[i]
    print(balance)

