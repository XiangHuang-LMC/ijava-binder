#ABA_OOP_A.py: very simple object-oriented design example.
# Entry and non-persistent storage of name.

def addressBook():
    aba = ABA_OOP_A()
    aba.go()

class ABA_OOP_A:
    def go(self):
        book = []
        name = input("Enter contact name ('exit' to quit): ")
        while name != "exit":
            book.append(name)
            name = input("Enter contact name ('exit' to quit): ")

        print()
        print("TEST: Display contents of address book")
        print("TEST: The address book contains the following contacts")
        for name in book:
            print(name)
