package com.github.coffeechris.calendlyapi.webhook;

import java.util.List;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request body of the Calendly Webhook.
 *
 * @see <a href="https://developer.calendly.com/docs/sample-webhook-data">https://developer.calendly.com/docs/sample-webhook-data</a>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestBody {
    private String event;
    private String time;
    private Payload payload;

    @Data
    public static class Payload {
        @JsonProperty("event_type")
        private EventType eventType;
        private Event event;
        private Invitee invitee;
        @JsonProperty("questions_and_answers")
        private List<QuestionAnswer> questionsAndAnswers;
        @JsonProperty("questions_and_responses")
        private QuestionResponses questionResponses;
        private Tracking tracking;
        @JsonProperty("old_event")
        private Event oldEvent;
        @JsonProperty("old_invitee")
        private Invitee oldInvitee;
        @JsonProperty("new_event")
        private Event newEvent;
        @JsonProperty("new_invitee")
        private Invitee newInvitee;

        @Data
        public static class EventType {
            private String uuid;
            private String kind;
            private String slug;
            private String name;
            private int duration;
            private Owner owner;

            @Data
            public static class Owner {
                private String type;
                private String uuid;
            }
        }

        @Data
        public static class Event {
            private String uuid;
            @JsonProperty("assigned_to")
            private List<String> assignedTo;
            @JsonProperty("extended_assigned_to")
            private List<ExtendedAssignedTo> extendedAssignedTo;
            @JsonProperty("start_time")
            private String startTime;
            @JsonProperty("start_time_pretty")
            private String startTimePretty;
            @JsonProperty("invitee_start_time")
            private String inviteeStartTime;
            @JsonProperty("invitee_start_time_pretty")
            private String inviteeStartTimePretty;
            @JsonProperty("end_time")
            private String endTime;
            @JsonProperty("end_time_pretty")
            private String endTimePretty;
            @JsonProperty("invitee_end_time")
            private String inviteeEndTime;
            @JsonProperty("invitee_end_time_pretty")
            private String inviteeEndTimePretty;
            @JsonProperty("created_at")
            private String createdAt;
            private String location;
            private boolean canceled;
            @JsonProperty("canceler_name")
            private String cancelerName;
            @JsonProperty("cancel_reason")
            private String cancelReason;
            @JsonProperty("canceled_at")
            private String canceledAt;

            @Data
            public static class ExtendedAssignedTo {
                private String name;
                private String email;
                private boolean primary;
            }
        }

        @Data
        public static class Invitee {
            private String uuid;
            @JsonProperty("first_name")
            private String firstName;
            @JsonProperty("last_name")
            private String lastName;
            private String name;
            private String email;
            private String timezone;
            @JsonProperty("created_at")
            private String createdAt;
            @JsonProperty("is_reschedule")
            private boolean isReschedule;
            private List<Payment> payments;
            private boolean canceled;
            @JsonProperty("canceler_name")
            private String cancelerName;
            @JsonProperty("cancel_reason")
            private String cancelReason;
            @JsonProperty("canceled_at")
            private String canceledAt;

            @Data
            public static class Payment {
                private String id;
                private String provider;
                private float amount;
                private String currency;
                private String terms;
                private boolean successful;
            }
        }

        @Data
        public static class QuestionAnswer {
            private String question;
            private String answer;
        }

        @Data
        public static class QuestionResponses {
            @JsonProperty("1_question")
            private String question1;
            @JsonProperty("1_response")
            private String response1;
            @JsonProperty("2_question")
            private String question2;
            @JsonProperty("2_response")
            private String response2;
            @JsonProperty("3_question")
            private String question3;
            @JsonProperty("3_response")
            private String response3;
            @JsonProperty("4_question")
            private String question4;
            @JsonProperty("4_response")
            private String response4;
        }

        @Data
        public static class Tracking {
            @JsonProperty("utm_campaign")
            private String utmCampaign;
            @JsonProperty("utm_source")
            private String utmSource;
            @JsonProperty("utm_medium")
            private String utmMedium;
            @JsonProperty("utm_content")
            private String utmContent;
            @JsonProperty("utm_term")
            private String utmTerm;
            @JsonProperty("salesforce_uuid")
            private String salesforceUuid;
        }
    }
}
