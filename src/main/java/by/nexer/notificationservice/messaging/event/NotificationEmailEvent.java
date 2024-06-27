package by.nexer.notificationservice.messaging.event;

import java.util.Objects;

public class NotificationEmailEvent {
    private String email;
    private String title;
    private String message;

    public NotificationEmailEvent() {
    }

    public NotificationEmailEvent(String email, String title, String message) {
        this.email = email;
        this.title = title;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationEmailEvent that = (NotificationEmailEvent) o;
        return Objects.equals(email, that.email) && Objects.equals(title, that.title) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, title, message);
    }

    @Override
    public String toString() {
        return "NotificationEmailEvent{" +
                "email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
