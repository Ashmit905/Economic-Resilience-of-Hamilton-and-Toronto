import { getAllHousings } from '../services/housingServices.ts'; // adjust path
import { Housing } from '../types/housing';

describe('getAllHousings (unit test)', () => {
  it('should return simulated data after a delay', async () => {
    const startTime = Date.now();
    const data: Housing[] = await getAllHousings();
    const endTime = Date.now();

    // 1) Verify the function returns the array of Housing objects
    expect(Array.isArray(data)).toBe(true);
    expect(data.length).toBeGreaterThan(0);

    // 2) Check a known field
    expect(data[0].cma).toBe('Hamilton');

    // 3) Ensure we have at least ~1 second delay
    // This is not always recommended in unit tests, but to demonstrate:
    const elapsed = endTime - startTime;
    expect(elapsed).toBeGreaterThanOrEqual(1000);
  });

  it('should return the correct Toronto data (example)', async () => {
    const data = await getAllHousings();
    const toronto = data.find((h) => h.cma === 'Toronto');
    expect(toronto).toBeDefined();
    expect(toronto?.month).toBe(1); // or some known month from your seed data
  });
});
