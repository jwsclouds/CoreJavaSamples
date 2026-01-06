class HelloWorld_Jdk25_Feature_Installed_Validation {
    /**
     * main method with no string args takes procedence only if no main(string[] args) present
     * @param args
     */
    void main() {
        System.out.println("main without string args");
    }

    /**
     * main method with string args takes procedence
     * @param args
     */
    void main(String[] args){
        System.out.println("main with string args");
        //main();
    }

}