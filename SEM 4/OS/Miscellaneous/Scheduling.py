class Process:
    def __init__(self, pid, arrival_time, burst_time, priority=None):
        self.pid = pid
        self.arrival_time = arrival_time
        self.burst_time = burst_time
        self.remaining_time = burst_time
        self.priority = priority
        self.waiting_time = 0
        self.turnaround_time = 0

def fcfs(processes):
    processes.sort(key=lambda x: x.arrival_time)
    current_time = 0
    for p in processes:
        if current_time < p.arrival_time:
            current_time = p.arrival_time
        p.waiting_time = current_time - p.arrival_time
        p.turnaround_time = p.waiting_time + p.burst_time
        current_time += p.burst_time

def sjf(processes):
    processes.sort(key=lambda x: (x.arrival_time, x.burst_time))
    current_time = 0
    queue = []
    i = 0
    n = len(processes)
    while i < n or queue:
        while i < n and processes[i].arrival_time <= current_time:
            queue.append(processes[i])
            i += 1
        if not queue:
            current_time = processes[i].arrival_time
            continue
        queue.sort(key=lambda x: x.burst_time)
        p = queue.pop(0)
        p.waiting_time = current_time - p.arrival_time
        p.turnaround_time = p.waiting_time + p.burst_time
        current_time += p.burst_time

def round_robin(processes, quantum):
    processes.sort(key=lambda x: x.arrival_time)
    queue = []
    current_time = 0
    i = 0
    n = len(processes)
    while i < n or queue:
        while i < n and processes[i].arrival_time <= current_time:
            queue.append(processes[i])
            i += 1
        if not queue:
            current_time = processes[i].arrival_time
            continue
        p = queue.pop(0)
        if p.remaining_time > quantum:
            current_time += quantum
            p.remaining_time -= quantum
            while i < n and processes[i].arrival_time <= current_time:
                queue.append(processes[i])
                i += 1
            queue.append(p)
        else:
            current_time += p.remaining_time
            p.waiting_time = current_time - p.arrival_time - p.burst_time
            p.turnaround_time = p.waiting_time + p.burst_time
            p.remaining_time = 0

def priority_scheduling(processes):
    processes.sort(key=lambda x: (x.arrival_time, x.priority))
    current_time = 0
    queue = []
    i = 0
    n = len(processes)
    while i < n or queue:
        while i < n and processes[i].arrival_time <= current_time:
            queue.append(processes[i])
            i += 1
        if not queue:
            current_time = processes[i].arrival_time
            continue
        queue.sort(key=lambda x: x.priority)
        p = queue.pop(0)
        p.waiting_time = current_time - p.arrival_time
        p.turnaround_time = p.waiting_time + p.burst_time
        current_time += p.burst_time

def calculate_avg_times(processes):
    total_wt = sum(p.waiting_time for p in processes)
    total_tat = sum(p.turnaround_time for p in processes)
    avg_wt = total_wt / len(processes)
    avg_tat = total_tat / len(processes)
    return avg_wt, avg_tat

def simulate_scheduling(processes, algorithm, quantum=None):
    
    temp_processes = [Process(p.pid, p.arrival_time, p.burst_time, p.priority) for p in processes]
    
    if algorithm == 'FCFS':
        fcfs(temp_processes)
    elif algorithm == 'SJF':
        sjf(temp_processes)
    elif algorithm == 'RR':
        round_robin(temp_processes, quantum)
    elif algorithm == 'Priority':
        priority_scheduling(temp_processes)
    else:
        raise ValueError("Invalid algorithm")
    
    avg_wt, avg_tat = calculate_avg_times(temp_processes)
    print(f"\n{algorithm} Scheduling:")
    print(f"Average Waiting Time: {avg_wt:.2f}")
    print(f"Average Turnaround Time: {avg_tat:.2f}")


if __name__ == "__main__":
    processes = [
        Process(1, 0, 6, 0),
        Process(2, 1, 4, 0),
        Process(3, 3, 5, 0),
        Process(4, 5, 3, 0)
    ]
    
    simulate_scheduling(processes, 'FCFS')
    simulate_scheduling(processes, 'SJF')
    simulate_scheduling(processes, 'RR', quantum=4)
    simulate_scheduling(processes, 'Priority')