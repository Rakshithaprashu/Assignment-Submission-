import random
import string

otp = ''
number_list = list(string.digits)
for i in range(6):
    otp += random.choice(number_list)

print(otp)

