# This is a Python program that creates a random file with
# a randomized good name with a random price.

# import random
import random
import sys
import os.path

from product import product

# list with names of goods
good_names = ['rice', 'cookies', 'milk', 'eggs', 'chips', 'meat', 'vegetables', 'cheese', 'bread', 'fruit']

# write in a file named input.txt
original_stdout = sys.stdout
with open('itemlist.txt', 'w') as f:
    sys.stdout = f
    # each line for 10 lines:
    products = []
    price = 0
    quantity = 0
    review = 0
    freshness = 0
    for x in range(10):
        #name of good (unrandomized), price, and rating (and item ID based on x value)
        price = random.randint(0,25)
        rating = random.randint(0,3)
        products.append(product((100+x), good_names[x], price, rating))
        print((100+x),",", good_names[x],",", price,",", rating)
        #output file
    sys.stdout = original_stdout
    
# if unable to find a file named'output.txt', create one
file_exists = os.path.exists('purchasehistory.txt')
if file_exists == False:
    original_stdout = sys.stdout
    with open('purchasehistory.txt', 'w') as f:
        sys.stdout = f
        # each line for 10 lines:
        price = 0
        quantity = 0
        review = 0
        freshness = 0
        for x in range(3):
            #name of good (unrandomized), price, quantity, review, freshness
            price = random.randint(0,25)
            rating = random.randint(0,3)
            products.append(product((100+x), good_names[x], price, rating))
            print((100+x),",", good_names[x],",", price,",", rating)
            #output file
        sys.stdout = original_stdout

# print out interface for user interaction
for item in products:
    product.report(item)