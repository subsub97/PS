ps = input()

stack = []
sum_val = 0
m_2 = 0
m_3 = 0

for i in range(len(ps)):
    if ps[i] == '(' or ps[i] =='[':
        if m_2 * m_3 == 0:
            mul_num = max(2**m_2,3**m_3)
        else:
            mul_num = (2**m_2) * (3**m_3)

        if ps[i] == '(':
            m_2 += 1
            val = 2
        else:
            m_3 += 1
            val = 3


        if len(stack) == 0:
            stack.append([ps[i], val])
        else:
            stack.append([ps[i],val * mul_num])


        if len(stack) >= 2:
            if stack[-2][0] == '(' or stack[-2][0] == '[':
                stack[-2][1] = 0
    else:
        if len(stack) == 0:
            sum_val =0
            break
        if ps[i] == ')' and stack[-1][0] == '(':
            sum_val += stack.pop()[1]
            m_2 -= 1
        elif ps[i] == ']' and stack[-1][0] =='[':
            sum_val += stack.pop()[1]
            m_3 -= 1
        else:
            sum_val = 0
            break
if stack:
    sum_val = 0
print(sum_val)