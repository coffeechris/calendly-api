package com.github.coffeechris.calendlyapi.webhook;

import java.util.List;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    }
/*
    "payload":{
      "questions_and_responses":{
        "1_question":"Skype ID",
        "1_response":"fake_skype_id",
        "2_question":"Facebook ID",
        "2_response":"fake_facebook_id",
        "3_question":"Twitter ID",
        "3_response":"fake_twitter_id",
        "4_question":"Google ID",
        "4_response":"fake_google_id"
      },
      "tracking":{
        "utm_campaign":null,
        "utm_source":null,
        "utm_medium":null,
        "utm_content":null,
        "utm_term":null,
        "salesforce_uuid":null
      },
      "old_event":null,
      "old_invitee":null,
      "new_event":null,
      "new_invitee":null
    }
    */
}
