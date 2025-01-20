package com.api.EventHub.controller;

import com.api.EventHub.model.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "User Controller")
public interface UserControllerApi {

    @Operation(
            summary = "Retrieve all users",
            description = "Retrieve all users present on the data base",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "All users retrieved",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    ResponseEntity<List<UserDto>> getAllUser();

    @Operation(
            summary = "Get user by ID",
            description = "Fetch a user by their unique ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User retrieved successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User not found"
                    )
            }
    )
    ResponseEntity<UserDto> getUserById(Long id);

    @Operation(
            summary = "Create a new user",
            description = "Create a new user by providing user details",
            requestBody = @RequestBody(
                    description = "Details of the user to be created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "User created successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDto.class))
                    )
            }
    )
    ResponseEntity<UserDto> createUser(UserDto userDto);

    @Operation(
            summary = "Delete user by ID",
            description = "Delete a user based on their unique ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User deleted successfully"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User not found"
                    )
            }
    )
    ResponseEntity<UserDto> deleteUser(Long id);

    @Operation(
            summary = "Update user by ID",
            description = "Update a user's details based on their unique ID",
            requestBody = @RequestBody(
                    description = "Updated user details",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User updated successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User not found"
                    )
            }
    )
    ResponseEntity<UserDto> updatedUser(Long id, UserDto userDto);
}
