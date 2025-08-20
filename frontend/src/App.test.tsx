import React from "react";
import { render, screen, fireEvent, waitFor } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";
import App from "./App";

test("renders main title", () => {
  render(
    <MemoryRouter>
      <App />
    </MemoryRouter>
  );
  const titleElement = screen.getByText("Economic Resilience of Hamilton and Toronto");
  expect(titleElement).toBeInTheDocument();
});

test("renders Housing Data button", () => {
  render(
    <MemoryRouter>
      <App />
    </MemoryRouter>
  );
  const housingButton = screen.getByText("Housing Data");
  expect(housingButton).toBeInTheDocument();
});

test("navigates to Housing page", async () => {
  render(
    <MemoryRouter initialEntries={["/"]}>
      <App />
    </MemoryRouter>
  );

  const housingButton = screen.getByText("Housing Data");
  fireEvent.click(housingButton);

  await waitFor(() => {
    expect(screen.getByText("Loading...")).toBeInTheDocument();
  });
});

test("renders Employment Data button", () => {
  render(
    <MemoryRouter>
      <App />
    </MemoryRouter>
  );
  const employmentButton = screen.getByText("Employment Data");
  expect(employmentButton).toBeInTheDocument();
});

test("navigates to Employment page", async () => {
  render(
    <MemoryRouter initialEntries={["/"]}>
      <App />
    </MemoryRouter>
  );

  const employmentButton = screen.getByText("Employment Data");
  fireEvent.click(employmentButton);

  await waitFor(() => {
    expect(screen.getByText("Loading...")).toBeInTheDocument();
  });
});

test("renders Student Stutas Data button", () => {
  render(
    <MemoryRouter>
      <App />
    </MemoryRouter>
  );
  const studentButton = screen.getByText("Student Status Data");
  expect(studentButton).toBeInTheDocument();
});

test("navigates to Student page", async () => {
  render(
    <MemoryRouter initialEntries={["/"]}>
      <App />
    </MemoryRouter>
  );

  const studentButton = screen.getByText("Student Status Data");
  fireEvent.click(studentButton);

  await waitFor(() => {
    expect(screen.getByText("Loading...")).toBeInTheDocument();
  });
});