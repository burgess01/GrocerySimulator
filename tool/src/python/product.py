class product:
	def __init__(self, id, name, price, rating):
		self.id = id
		self.name = name
		self.price = price
		self.rating = rating
	def report(self):
		print("-----------------------")
		print("Product Id:", self.id)
		print("Product Name:", self.name)
		print("Product Price:", self.price)
		print("Product Rating", self.rating)
		print("-----------------------")