package OOPS.Exception;

class AgeRestrictionException extends Exception {
    public AgeRestrictionException(String message) {
        super(message);
    }
}

public class cobiningThrowAndThrows {

    public void validateVoter(int age) throws AgeRestrictionException {
        if (age < 18) {
            throw new AgeRestrictionException("Must be 18+ to vote. Provided age: " + age);
        }
        System.out.println("Welcome to the voting booth!");
    }

    public static void main(String[] args) {
        cobiningThrowAndThrows votingSystem = new cobiningThrowAndThrows();
        try {
            votingSystem.validateVoter(16);
        } catch (AgeRestrictionException e) {
            System.out.println("Voting Error: " + e.getMessage());
        }
    }
}
