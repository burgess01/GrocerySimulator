# This is a Python program that creates a random file with
# a randomized good name with a random price.

# import random
import random
import sys

# list with names of goods
good_names = ['rice', 'cookie', 'milk', 'egg', 'chips', 'meat', 'vegetable', 'cheese', 'bread', 'fruit']

# write in a file named input.txt
original_stdout = sys.stdout
with open('input.txt', 'w') as f:
    sys.stdout = f
    # each line for 10 lines:
    price = 0
    quantity = 0
    review = 0
    freshness = 0
    for x in range(10):
        #name of good (unrandomized), price, quantity, review, freshness
        price = random.randint(0,25)
        quantity = random.randint(0,50)
        review = random.randint(0,10)
        freshness = random.randint(0,3)
        print(good_names[x],",", price,",", quantity,",",review,",",freshness)
        #output file
    sys.stdout = original_stdout
