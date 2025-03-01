package com.hieptran.smarthome_server.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("humiAutoOptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HumiAutoOption implements AutoOption {
//    @Id
//    private ObjectId id;
//
//    @Field("createdAt")
//    @CreatedDate
//    private LocalDateTime createdAt;

    @Field("updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Field("high")
    private Float high;

    @Field("low")
    private Float low;

    @Field("highDevices")
    private List<DeviceAuto> highDevices;

    @Field("lowDevices")
    private List<DeviceAuto> lowDevices;

    @Override
    public Object getGreaterThan() {
        return high;
    }

    @Override
    public Object getLessThan() {
        return low;
    }
}
