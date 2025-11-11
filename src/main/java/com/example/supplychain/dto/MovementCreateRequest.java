package com.example.supplychain.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public class MovementCreateRequest 
{
    public UUID productId;
    public UUID fromLocationId;
    public UUID toLocationId;
    public OffsetDateTime occurredAt;
    public double quantity;
    public String notes;
}
