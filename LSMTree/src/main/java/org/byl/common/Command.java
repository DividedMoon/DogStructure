package common;

public record Command(CommandType type, String key, byte[] value) {
    public Command {
        if (type == CommandType.PUT && value == null) {
            throw new IllegalArgumentException("PUT command must have a value");
        }
        if (type==CommandType.DELETE && )
    }
}

