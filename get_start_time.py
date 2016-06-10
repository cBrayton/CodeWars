def get_start_time(schedules, duration):
    '''
    Takes a 3d array of people, meetings, and start/stop times and returns a start time for a new meeting of the given duration that all
    people can attend.
    All times are given in military time.
    '''
    earliest_start = '09:00'
    earliest_end = '{:0>2}'.format(9+duration/60) +':'+ '{:0>2}'.format(duration%60)
    meetings_checked = [0] * len(schedules)
    times_updated = True
    while times_updated:
        times_updated = False
        for person in range(len(schedules)):
            if (meetings_checked[person] >= len(schedules[person])): continue
            if (time_comp(schedules[person][meetings_checked[person]][1], earliest_start) and meetings_checked[person] < len(schedules[person])-1):
                meetings_checked[person] = meetings_checked[person] + 1
                times_updated = True
            if (time_comp(earliest_end, schedules[person][meetings_checked[person]][0])):
                continue
            if (time_comp(schedules[person][meetings_checked[person]][0], earliest_end) and
            time_comp(earliest_start, schedules[person][meetings_checked[person]][1])):
                earliest_start = schedules[person][meetings_checked[person]][1]
                earliest_end = '{:0>2}'.format(int(earliest_start[:2])+duration/60) +':'+ '{:0>2}'.format((int(earliest_start[-2:])+duration%60)%60)
                if (int(earliest_start[-2:]) + duration%60 >= 60):
                    earliest_end = '{:0>2}'.format(int(earliest_end[:2])+1) + earliest_end[2:]
                if (meetings_checked[person] < len(schedules[person])-1):
                    meetings_checked[person] = meetings_checked[person] + 1
                times_updated = True
    if (time_comp('19:00',earliest_end)): return None
    return earliest_start
    
def time_comp(a, b):
    '''
    Checks if a is earlier than b, when both are strings representing military time to the minute.
    '''
    if (a[:2] < b[:2]): return True
    elif (a[-2:] < b[-2:] and a[:2] == b[:2]): return True
    else: return False