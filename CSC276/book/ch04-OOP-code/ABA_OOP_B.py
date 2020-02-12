#ABA_OOP_B.py: very simple object-oriented design example.
# Entry and non-persistent storage of name (better).

def addressBook():
    aba = ABA_OOP_B()
    aba.go()

class ABA_OOP_B:
    def go(self):
        self.book = []
        name = self.getName()
        while name != "exit":
            self.book.append(name)
            name = self.getName()

        self.displayBook()

    def getName(self):
        return input("Enter contact name ('exit' to quit): ")

    def displayBook(self):
        print()
        print("TEST: Display contents of address book")
        print("TEST: The address book contains the following contacts")
        for name in self.book:
            print(name)
