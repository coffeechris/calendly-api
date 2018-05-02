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
            String uuid;
            @JsonProperty("assigned_to")
            List<String> assignedTo;
        }
    }
/*
    "payload":{

      "event":{
        "uuid":"BBBBBBBBBBBBBBBB",
        "assigned_to":[
          "Jane Sample Data"
        ],
        "extended_assigned_to":[
          {
            "name":"Jane Sample Data",
            "email":"user@example.com",
            "primary":false
          }
        ],
        "start_time":"2018-03-14T12:00:00Z",
        "start_time_pretty":"12:00pm - Wednesday, March 14, 2018",
        "invitee_start_time":"2018-03-14T12:00:00Z",
        "invitee_start_time_pretty":"12:00pm - Wednesday, March 14, 2018",
        "end_time":"2018-03-14T12:15:00Z",
        "end_time_pretty":"12:15pm - Wednesday, March 14, 2018",
        "invitee_end_time":"2018-03-14T12:15:00Z",
        "invitee_end_time_pretty":"12:15pm - Wednesday, March 14, 2018",
        "created_at":"2018-03-14T00:00:00Z",
        "location":"The Coffee Shop",
        "canceled":false,
        "canceler_name":null,
        "cancel_reason":null,
        "canceled_at":null
      },
      "invitee":{
        "uuid":"AAAAAAAAAAAAAAAA",
        "first_name":"Joe",
        "last_name":"Sample Data",
        "name":"Joe Sample Data",
        "email":"not.a.real.email@example.com",
        "timezone":"UTC",
        "created_at":"2018-03-14T00:00:00Z",
        "is_reschedule":false,
        "payments":[
          {
            "id":"ch_AAAAAAAAAAAAAAAAAAAAAAAA",
            "provider":"stripe",
            "amount":1234.56,
            "currency":"USD",
            "terms":"sample terms of payment (up to 1,024 characters)",
            "successful":true
          }
        ],
        "canceled":false,
        "canceler_name":null,
        "cancel_reason":null,
        "canceled_at":null
      },
      "questions_and_answers":[
        {
          "question":"Skype ID",
          "answer":"fake_skype_id"
        },
        {
          "question":"Facebook ID",
          "answer":"fake_facebook_id"
        },
        {
          "question":"Twitter ID",
          "answer":"fake_twitter_id"
        },
        {
          "question":"Google ID",
          "answer":"fake_google_id"
        }
      ],
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
