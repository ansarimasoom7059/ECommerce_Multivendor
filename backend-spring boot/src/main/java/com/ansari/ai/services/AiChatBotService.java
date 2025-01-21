package com.ansari.ai.services;

import com.ansari.exception.ProductException;
import com.ansari.response.ApiResponse;

public interface AiChatBotService {

    ApiResponse aiChatBot(String prompt,Long productId,Long userId) throws ProductException;
}
