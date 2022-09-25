class Method {
    // public is a key word (access modifier)
    // declare the return type - String
    // if you're declaring a string, you have to have a return
    // if you're not sure what you're declaring, you can replace String with void
    // greeter is the name of the function
    // in the parens, you have to declare the type you're going to pass
    public String greeter(String name, Date date) {
        return "hello world";
    }

    // method signatures
    greeter(String, Date)

    // method overloading
    //you can have 2 methods in the same file with the same name
    // but they need to have a different signature
    // or a different set of parameters to pass in
    public String greeter(String name) {
        return "hello world"
    }
}

// the complier knows what functions is getting called
// by what arguments you're passing in
// if you're called greeter with a string that's being passed in, then it knows to call the greeter with Sting name
// 